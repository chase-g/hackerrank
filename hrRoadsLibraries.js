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

function roadsAndLibraries(n, c_lib, c_road, cities) {
    // Complete this function
    if(c_road >= c_lib || cities === undefined || cities.length == 0){
      return c_lib * n;
    }
    else {
      var roadMap = new Map();
      var reached = new Map();

      function makeMap(conn) {
        var first = Number(conn[0]);
        var second = Number(conn[1]);
        if(roadMap.get(first) === undefined || roadMap.get(first).size == 0){
          roadMap.set(first, [second]);
          reached.set(first, false);
        }
          else {
          roadMap.get(first).push(second);
        }
        if(roadMap.get(second) === undefined || roadMap.get(second).size == 0){
            roadMap.set(second, [first]);
            reached.set(second, false);
          }
        else {
          roadMap.get(second).push(first);
        }
      }

      for(var i = 0; i < cities.length; i++) {
        makeMap(cities[i].map(Number));
      }

      var index = 0;
      var clusterGroups = [1];

      function findClusters(city, cluster) {
        reached.set(city, true);
        for(const neighbor of roadMap.get(city)) {
          if(!reached.get(neighbor))  {
             reached.set(neighbor, true);
             clusterGroups[cluster]++;
             findClusters(neighbor, cluster);
          }
         }
       }

      for (const [key, value] of roadMap.entries()) {
        if(!reached.get(key)){
          clusterGroups[index] = 1;
          findClusters(key, index);
          index = index + 1;
        }
      }

      var lowestCost = (n - reached.size) * c_lib;

        for(const i of clusterGroups) {
        lowestCost += (((i - 1) * c_road) + c_lib);
      }

      return String(lowestCost);
      }

}

function main() {
    var q = parseInt(readLine());
    for(var a0 = 0; a0 < q; a0++){
        var n_temp = readLine().split(' ');
        var n = parseInt(n_temp[0]);
        var m = parseInt(n_temp[1]);
        var c_lib = parseInt(n_temp[2]);
        var c_road = parseInt(n_temp[3]);
        var cities = [];
        for(cities_i = 0; cities_i < m; cities_i++){
           cities[cities_i] = readLine().split(' ');
           cities[cities_i] = cities[cities_i].map(Number);
        }
        var result = roadsAndLibraries(n, c_lib, c_road, cities);
        process.stdout.write("" + result + "\n");
    }

}
