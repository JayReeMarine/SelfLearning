"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
function addTwo(num) {
    return num + 2;
}
function getUpper(val) {
    return val.toUpperCase();
}
function signUpUser(name, email, isPaid) {
    // do some database stuff
    console.log("User name is: ".concat(name, ", email is: ").concat(email, ", paid: ").concat(isPaid));
}
var loginUser = function (name, email, isPaid) {
    if (isPaid === void 0) { isPaid = false; }
};
addTwo(2);
getUpper("jay");
