import {useEffect, useState} from "react";
import axios from "axios";

export function useAxiosGet<T>(url: string, transform: (json: T) => T, payload: any = {}) {
    const [data, setData] = useState<T | null>(null);
    const [error, setError] = useState("");
    const [loaded, setLoaded] = useState(false);

    useEffect(() => {
        axios
            .get(url, payload)
            .then((response) => setData(transform(response.data as T)))
            .catch((error) => setError(error.message))
            .finally(() => setLoaded(true));
    }, []);

    return {data, error, loaded};
}

declare global {
    interface Array<T> {
        chunk(chunkSize: number): Array<Array<T>>
    }
}

Array.prototype.chunk = function (chunkSize: number) {
    const R = [];
    for (let i = 0; i < this.length; i += chunkSize)
        R.push(this.slice(i, i + chunkSize));
    return R;
};

export function shuffle<T>(array: T[]): T[] {
    let currentIndex = array.length,  randomIndex;

    // While there remain elements to shuffle.
    while (currentIndex != 0) {

        // Pick a remaining element.
        randomIndex = Math.floor(Math.random() * currentIndex);
        currentIndex--;

        // And swap it with the current element.
        [array[currentIndex], array[randomIndex]] = [
            array[randomIndex], array[currentIndex]];
    }

    return array;
};
