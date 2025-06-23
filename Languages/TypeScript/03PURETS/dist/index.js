"use strict";
// class User {
//     public email: string;
//     private name: string;
//     readonly city: string = "Incheon"
//     constructor(email: string,name: string, ) {
//         this.email= email;
//         this.name = name;
//     }
// }
class User {
    constructor(email, name) {
        this.email = email;
        this.name = name;
        this._courseCount = 1;
        this.city = "Incheon";
    }
    deleteToken() {
        console.log("Token deleted");
    }
    get getAppleEmail() {
        return 'apple${this.email}';
    }
    get courseCount() {
        return this._courseCount;
    }
    set courseCount(courseNum) {
        if (courseNum <= 1) {
            throw new Error("Course count should be more than 1");
        }
        this._courseCount = courseNum;
    }
}
class SubUser extends User {
    constructor() {
        super(...arguments);
        this.isFamily = true;
    }
    changeCourseCount() {
        this.courseCount = 4;
    }
}
const jay = new User("jay@com", "Jay");
jay.city;
