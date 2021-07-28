

Promise.some = function(promiseList) {
  let res = [];
  let requestNumber = promiseList.length;
  let request = 0;
  return new Promise((resolve,rej)=>{
    for (let i=0; i<promiseList.length;i++ ) {
      promiseList[i].then(data=>{
        res[i] = data;
        request++;
        if(requestNumber === request) {
          resolve(res);
        }
      }).catch(err=>{
        request++;
        res[i] = false;
        if(requestNumber === request) {
          resolve(res);
        }
      })
    }
  })
}

