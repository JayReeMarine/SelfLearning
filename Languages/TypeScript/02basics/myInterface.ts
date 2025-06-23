interface iUser {
    readonly dbID: number
    email: string
    userId: number
    googleId?: string
    //startTrail: () => string
    startTrail(): string
    getCoupon(couponName: string, value: number): number
}

interface iUser {
    githubToken: string
}

interface iAdmin extends iUser {
    role: "admin" | "ta"
}


const jayRee: iAdmin = {
    role: "admin",
    dbID: 22,
    email: "Jay@com",
    userId: 123,
    githubToken: "gh123",
    startTrail: () => {
        return "Trail started"
    },
    getCoupon: (name: "Jay", off: 10) => {
        return 10
    }
}

jayRee.email = "Ree@com"