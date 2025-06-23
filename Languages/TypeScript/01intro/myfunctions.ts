function addTwo(num: number): number {

    return num + 2
}

function getUpper(val: string){
    return val.toUpperCase()
}

function signUpUser(name: string, email: string, isPaid: boolean){
    // do some database stuff
    console.log(`User name is: ${name}, email is: ${email}, paid: ${isPaid}`)
}

let loginUser = (name: string, email:string, isPaid: boolean = false) => {}

addTwo(2)

getUpper("jay")



function getValue(myval: number): boolean | string {
    if(myval > 5){
        return true
    }
    return "200 OK"
}


const getHello = (s: string): string => {
    return ""
}

const heros = ["thor", "spiderman", "ironman"]

heros.map((hero:string):string =>{
    return `hero is ${hero}`
})

function consoleError(errmsg: string): void{
    console.log(errmsg);
}

function handleError(errmsg: string): never{
    throw new Error(errmsg)
}

export {};