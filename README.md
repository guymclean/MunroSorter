# MunroSorter
Java library to filter munro CSV files for XDesign

The library can be used as follows:

The most basic operation is for using it to read a CSV file and return a list of munro objects.
Munro objects have a name, height (meters), category (munro/top) and grid reference.

For example:

<pre>
String filepath = "C:\\path\\to\\file.csv";    
List&lt;Munro&gt; munros = new MunroSorter
        .Builder(filepath)
        .build();
</pre>
        
will return a list of munros occurring in the specified file.
        
A number of filtering features can be applied with the following operations        

- filterCategory(char filterOption)
the filter option can be 'm' to return only munros or 't' to return only munro tops

 - sortByHeight(char sortingParam) 
the sorting paramater can be 'a' to sort ascending or 'd' to sort descending

- sortByName(char sortingParam)
the sorting paramater can be 'a' to sort ascending or 'd' to sort descending

- minHeight(int height)
munros with smaller heights than that specified are removed from the list

- maxHeight(int height)
munros with larger heights than that specified are removed from the list

- limit(int limit)
limits the size of the list to that specified by limit, after all other filters have been completed

The order in which filter features are specified does not matter.
If both sorting by name and height are specified, the list will be sorted by height, according to the height sorting parameter, and then munros with the same height will be sorted according to the name sorting parameter
Here are a couple of examples of the types of queries that can be executed:

<pre>
List&lt;Munro&gt; munros = new MunroSorter
        .Builder(filepath)
        .sortByHeight('a')
        .sortByName('d')
        .minHeight(1001)
        .maxHeight(1050)
        .filterCategory('m')
        .limit(10)
        .build();
</pre>

<pre>
List&lt;Munro&gt; munros = new MunroSorter
        .Builder(filepath)
        .sortByHeight('d')
        .filterCategory('m')
        .build();
</pre>
