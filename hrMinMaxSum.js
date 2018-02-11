process.stdin.resume();
process.stdin.setEncoding('ascii');

var input_stdin = "";
var input_stdin_array = "";
var input_currentline = 0;

process.stdin.on('data', function (data) {
    input_stdin += data;
});

process.stdin.on('end', function () {
    input_stdin_array = input_stdin.split("\n");
    main();
});

function readLine() {
    return input_stdin_array[input_currentline++];
}

/////////////// ignore above this line ////////////////////

function miniMaxSum(arr) {
    function add(a, b) { return a + b; }
    function dropIndex(someArray, index) {
      const updated = someArray.slice(0, index).concat(someArray.slice(index + 1, someArray.length));
      return updated;
    }
    const minIndex = arr.indexOf(Math.min.apply(Math, arr));
    const maxIndex = arr.indexOf(Math.max.apply(Math, arr));
    const maxSum = dropIndex(arr, minIndex).reduce(add, 0);
    const minSum = dropIndex(arr, maxIndex).reduce(add, 0);
    console.log(minSum + " " + maxSum);
}

function main() {
    arr = readLine().split(' ');
    arr = arr.map(Number);
    miniMaxSum(arr);

}
