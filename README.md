# Examples for ProRunVis

Demonstration of ProRunVis visualization/debugger for some real-world Java code.

## Running an Example

1. Follow the instructions in the top-level repo to set up and build ProRunVis.
2. Start the web-interface.
   `java -jar prorunvis-api/build/libs/prorunvis-api.jar`
3. Open Web-Browser on http://localhost:8080/
4. Click on `Browse...` and select the folder of the example to "upload".
5. Wait for around 3 seconds (or longer) until trace is recorded, parsed and displayed.
6. Now everything executed in the main method should be green with blue links to the method calls.

You can click on them to see what happened in these functions.
You can click on the `return` or the current method's name to go back to the caller.
You can see witch `if` or `else` branches are executed by the green highlighting.
You can also select a different loop iterations for any `for`/`while`/`do-while` loop. Just click around!

## Example Description
### Dual Pivot Quicksort

This example consists of `java/util/DualPivotQuicksort.java` from the official OpenJDK sources
(renamed to `java_copy/util` to make it compile).
Plus a `main` method with some sample arrays.

This is a real-world example and features both simple `if`/`else` control flow,
as well as nested `while`/`for`/`do-while` loops and recurse method calls. Note that
the visualization picks correct instances of the overloaded method calls
to `sort()`.

## LICENSE

The `LICENSE` for each example can be found in the respective folder.
