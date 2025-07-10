// https://leetcode.com/problems/is-object-empty/description/


/**
 * @param {Object|Array} obj
 * @return {boolean}
 */
var isEmpty = function(obj) {
    // if (Array.isArray(obj)){
    //     for(let i=0; i< obj.length; i++) {
    //         return false;
    //     }
    //     return true;
    // }

    // for (let key in obj){
    //     if (obj.hasOwnProperty(key)){
    //         return false;
    //     }
    // }

    // return true

    if (Array.isArray(obj)) return obj.length === 0;
    for (let key in obj) return false;
    return true;

};

// testing
console.log(isEmpty({})); // true
console.log(isEmpty({ a: 1 })); // false
console.log(isEmpty([])); // true
console.log(isEmpty([1, 2, 3])); // false