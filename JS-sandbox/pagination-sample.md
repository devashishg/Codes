  ```js
  // write an api to return paginated data with limit and offset
  // api should have below query parameters
  // 1. sort key //name, age, email, address, favouriteFruit, gender, company, registered
  // 2. sort order /asc, desc
  // 3. searchParam //name(P), age(F), email(P), address(P), favouriteFruit(F), gender(F), company(P)
  // Partial, Full
  
  // 4. limit
  // 5. offset
  // 6. tags [a, b]
  
  
  
  
 
  const options = {
      sortKey: 'age',  
      sortOrder: 'desc',// asc
      searchParam: "male",
      limit: 10,
      offset: 0,
      tags: [],
  }
  
  /**
   * order of operation
   * 
   * All the tags
   * Search 
   * sort
   * offset ignore, 
   * next N
   * 
   */

// Partial match of String
partialMatch = (str1, str2) => {
    return !!str2.toLowerCase().match(str1.toLowerCase())
};

// Implementation

const filterResults = (options, data) => {
    const { sortKey, sortOrder, searchParam, limit, offset, tags } = options;
    // check tags, search for respective terms and after that sort based on ascending and descending.
    const processedData = data.filter(obj => {
        return tags.every(v => obj.tags.includes(v)) && (
            partialMatch(searchParam, obj.name) ||
            partialMatch(searchParam, obj.email) ||
            partialMatch(searchParam, obj.address) ||
            partialMatch(searchParam, obj.company) ||
            obj.favouriteFruit === searchParam ||
            obj.gender === searchParam ||
            obj.age == searchParam 
        );
    }).sort((a, b) => {
        const Astr = typeof a[sortKey] === 'string' ? a[sortKey].toUpperCase() : a[sortKey];
        const Bstr = typeof b[sortKey] === 'string' ? b[sortKey].toUpperCase() : b[sortKey];
        return (Astr > Bstr ? 1 : Astr === Bstr ? 0 : -1) * (sortOrder === 'asc' ? 1 : -1);
    });
    const results = processedData.slice(offset, offset + limit);
    return {
        results: results, // output
        offset: offset + results.length, // offset values
        size: results.length, // output size
        totalResults: processedData.length // Total search results of query
    };
}

const result = filterResults(options, data)
```

