process.stdin.resume();
process.stdin.setEncoding('utf8');
let ind=0;
process.stdin.on('data', function(chunk){
  arr = chunk.split('\n');
});

process.stdin.on('end', function() {
    let T=Number(arr[ind++]);
    for(i=0;i<T;i++){
    	let N=Number(arr[ind].split(' ')[0]);
    	let K=Number(arr[ind++].split(' ')[1]);
    	let arr1=arr[ind++].split(' ');
    	arr1=arr1.map((v)=>{return Number(v)});
    	let min=arr1[0],max=arr1[0],minInd=0,maxInd=0;
    	arr1.forEach((val,ind)=>{
    	if(val>max){max=val;maxInd=ind;}
    	if(val<min){min=val;minInd=ind}}
    	);
    	if(minInd<maxInd){
    	console.log(min+' '+max);}else{console.log(max+' '+min);}
    }
});
