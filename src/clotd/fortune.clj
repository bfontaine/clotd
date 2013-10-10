(ns clotd.fortune)

(defn read-quotes
  "Read a list of quotes from a fortune file.
   Quotes are separated by a '%' character on its own line. We assume that
   lines are ended by \\n."
  [filename]
  ;; We'll eventually store all quotes in memory, so using 'slurp' is
  ;; not less efficient than a BufferedReader here
  (clojure.string/split (slurp filename) #"\n%\n"))

