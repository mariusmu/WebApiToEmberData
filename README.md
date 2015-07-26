# WebApiToEmberData
Program to transform ASP.NET Web Api Models to Ember Data Models easy. In Java (jar)

### Usage
``` java -jar Program pathToCsharpModel.cs [belongs-to attribute name] [belongs-to type name] ```

The last to arguments are optional and should be used if DS.belongsTo is needed.

### Types
The program looks for string, int, bool and List, and can be nullable (?) optionally

* string -> string,
* int -> number,
* bool -> boolean,
* List<Type> -> hasMany('type')

### Licence
Apache Common

