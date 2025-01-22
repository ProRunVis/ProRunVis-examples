# Symbolic Execution with JBMC for SnowWhite Example

After we recorded a control flow trace, we want to reconstruct variable values for a specific method. For this, we can retrace the control flow using symbolic execution.

Here, we do this with the SnowWhite example and the bounded model checker JBMC.

## Requirements

JBMC's home page: https://www.cprover.org/jbmc/

cbmc and jbmc's github: https://github.com/diffblue/cbmc

1. Clone the cbmc from github
2. Build it, instructions can be found in cbmc's `COMPILING.md`
3. Afterwards, you can find the jbmc binary in `build/bin/jbmc`

## Example Preparation

1. Instrumentation with ProRunVis. For your convenience, `SnowWhite.java` was already instrumented in this folder.
2. Add `prorunvis/Trace.java` and `org/cprover/CProver.java` to the source folder. For other examples, just copy them from this example.
3. Convert the unprocessed trace into an `int[]` array (we only need the partial trace of the function we want to inspect).
4. Add the `int[]` array at the beginning of the method you want to inspect. Example:
   ```
   prorunvis.Trace.trace = new int[]{5,3,0,1,1,2,1,2,1,6,4};
   ```
5. Set the trace index to the first element of the partial trace for this inspected method. For example, to set `trace[2] == 0` as first element:
   ```
   prorunvis.Trace.index = 2;
   ```
6. After the last element, typically before a `return` statement add:
   ```
   assert(false);
   ```
7. Compile the example with java, with debugging enabled:
   ```
   javac -g SnowWhite.java
   ```

## Run JBMC and inspect output

```
jbmc "SnowWhite.indexMax:([I)I" --unwind 5 --unwinding-assertions --disable-uncaught-exception-check --throw-runtime-exceptions --max-nondet-array-length 5  --json-ui > model-indexMax.json
```

Notes:

* `jbmc` might be replaced by the path to jbmc (in the cbmc folder in `build/bin/jbmc`)
* First argument is the fully qualified name of the function. 
* JBMC needs maximum unwinding and max nondet array length. Unwinding means how many loop iterations are executed at maximum. Array length restricts the length of arrays. Make sure that the execution does not exceed these limits!
* The final report is in model-indexMax.json, including a counter example we will use. We are only interested in counter examples that violate the `assert(false)` we inserted. That is why we have `--disable-uncought-exception-check` and `--throw-runtime-exceptions` to disable other assertions. A sample `model-indexMax-sample.json` is included in the folder.

