// ## TUTORIAL USING EX1
// use file input.txt
val inputFile = sc.textFile("input.txt")
// create Dataset of Words 
var onlyWords = inputFile.flatMap(line => line.split(" "))
var words = onlyWords.map(word => (word, 1))
words = words.reduceByKey(_+_)
words.collect()
// Sumarizing:
val counts = inputfile.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey(_+_)
// for debugging purposes:
counts.toDebugString
// Actions: Save result
// This create a folder called output.
counts.saveAsTextFile("output")

// ## UN Persist the Storage
// Before UN-persisting, if you want to see the storage space that is used for this application, then use the following URL in your browser.

http://localhost:4040


// If you want to UN-persist the storage space of particular RDD, then use the following command.
counts.unpersist()