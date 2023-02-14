type StatColumnProps = {
    words: String[],
    title: String,
}

const N = 2
let id = 0

export default function StatColumn({words, title}: StatColumnProps) {
    if (words.length === 0) {
        return (
            <div className="App-game-stat-column">
                <p className="font-link-bold App-game-stat-column-p">{title}</p>
                <p className="font-link-base App-game-stat-column-p-small">No statistics yet</p>
            </div>
        )
    }
    return (
        <div className="App-game-stat-column">
            <p className="font-link-bold App-game-stat-column-p">{title}</p>
            {(words.length > N * 3 ? words?.reverse().slice(0, N * 3) : words)?.chunk(N)?.map((row: Array<String> | null, i: number) => (
                <div className="App-game-stat-row" key={"Key:" + id++}>
                    {row?.map((word, j) => (
                        <div className="App-game-stat-row-item"><pre className="font-link-base App-game-stat-row-item-p">{word}</pre></div>
                    ))}
                </div>))}
            {
                words.length - N * 3 > 0 ? (
                    <p className="font-link-base App-game-stat-column-p-small">and {words.length - 6} more...</p>
                ) : <p></p>
            }
        </div>
    )
}