// const User = {
//     name: "jay",
//     email: "example.dev",
//     isActive: true
// }

// function createUser({name: string, isPaid: boolean}){}

// let newUser = {name: "jay", isPaid: false, email: "example.dev"}

// createUser(newUser)

// function createCourse():{name: string, price: number} {
//     return {name: "reactjs", price: 399}
// }



// type User = {
//     name: string;
//     email: string;
//     isActive: boolean
// }

// function createUser(user: User): User{
//     return {name: " ", email: "", isActive: false}
// }

// createUser({name: " ", email: "", isActive: false})


type User = {
    readonly _id: string;
    name : string;
    email: string;
    isActive: boolean;
    credcardDetails?: number;
}


let myUser: User = {
    _id: "1234",
    name: "jay",
    email: "example.dev",
    isActive: false
}

type cardNumber = {
    cardnumber: string;
}

type cardDate = {
    cardDate: string;
}

type cardDetails = cardNumber & cardDate & {
    cvv: number;
}

let myCard: cardDetails = {
    cardnumber: "1234",
    cardDate: "12/23",
    cvv: 123
}


myUser.email = "example.dev"
// myUser._id = "asa"

export {};