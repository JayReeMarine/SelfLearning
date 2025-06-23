let score: number | string = 33

score = 44

score = '55'


type User2 = {
    name: string;
    id: number;
}

type Admin = {
    username : string;
    id: number;
}

let jay: User2 | Admin = {
    name: 'Jay',
    id: 1
}
jay = {
    username: 'Jay',
    id: 2
}

function getDbId(id: number | string) {
    // make a call to the database
    console.log(`DB ID is: ${id}`)
}
getDbId(3)
getDbId('3')


//array

const data: number[] | string[] = [1, 2, 3, 4, 5]
const data2: (number | string)[] = [1, 2, 3, 4, 5, '6', '7', '8']

let pi: 3.14 = 3.14
// pi = 3.14159 // Error: Type '3.14159' is not assignable to type '3.14'.

let seatAllotment: "aisle" | "middle" | "window"
seatAllotment = "aisle" // Valid
// seatAllotment = "front" // Error: Type '"front"' is not assignable to type '"aisle" | "middle" | "window"'.