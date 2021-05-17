- create yaml file then run ` kubectl apply -f 'yaml file name'`
- To check which pods are running `kubectl get pods`



config yaml apiVesrion, v1 represent the default list of Objects in the pool,where the types are defined 

go to have version mentioned for image.

- similar to docker we can start a shell or run commands inside the container,which is runnint inside some pod `kubectl  exec -it 'pod_name' 'command'`
- Description of pod `kubectl describe pod 'pod_name'`.
