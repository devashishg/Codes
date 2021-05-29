Graphql

- Query
- Mutation
- Subscriptions

In case If there are multiple query on same field, and different params in that case we can use `Alias`

```
Query {
  first: Groups(id:1){
    name
    location
  }
  second: Groups(id:4){
    name
    location
    description
  }
}
```
we can define and use Fregments when same fields we query on multiple times

```
Query {
  first: Groups(id:1){
    ...details
  }
  second: Groups(id:4){
    ...details
  }
}

fregment details on Groups {
    name
    location
    description
}
```



Query by naming the operation and variables

```
query myQuery($id:Int!) {
  Groups(id: $id){
    name
    location
    description
  }
}

// Just pass the variables to Query variables section

```
