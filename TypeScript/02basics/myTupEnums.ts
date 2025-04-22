// const user: (string|number)[] = ['hc',1]

let tUser: [string,number,boolean]

tUser = ["hc", 1, true]

let rgb: [number, number, number] = [255, 255, 255]

type User = [number, string]

const newUser: User = [112, "hc"]

newUser[1] = "hello.com"
// newUser.push(true)

enum SeatChoice {
    AISLE = "aisle",
    MIDDLE = "middle",
    WINDOW = "window",
    FRONT = 3
}

const hcSeat = SeatChoice.AISLE







export {}