# WebApiToEmberData
Program to transform ASP.NET Web Api Models to Ember Data Models easy. In Java (jar)

### Usage
``` java -jar Program.jar pathToCsharpModel.cs [belongs-to attribute name] [belongs-to type name] ```

The last to arguments are optional and should be used if DS.belongsTo is needed.

### Types
The program looks for string, int, bool and List, and can be nullable (?) optionally

* public string -> string,
* public int -> number,
* public bool -> boolean,
* public List<Type> -> hasMany('type')
* NOTE: Date Not yet implemented

### Please note
* The program does only look for the types (Ref heading "Type") in a Model file. Ember-Data does not allow other object types etc.
* Does not scan for anonymous inner classes. (If you in a Controller do "return new { type : value }", it will not work)

### Licence
Apache Common
