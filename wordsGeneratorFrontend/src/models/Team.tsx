export class Team {
    id: number
    points: number = 0
    name: string

    constructor(id: number, points: number, name: string) {
        this.id = id
        this.points = points
        this.name = name
    }
}

export class GameTeams {
    teams: Array<Team>
    currentTeamIndex: number

    constructor(teams: Array<Team>) {
        this.teams = teams
        this.currentTeamIndex = 0
    }

    addPoints(points: number) {
        this.teams[this.currentTeamIndex].points += points
    }

    nextTeam(points: number) {
        this.addPoints(points)
        this.currentTeamIndex += 1
        if (this.currentTeamIndex >= this.teams.length) {
            this.currentTeamIndex = 0
        }
    }
}
