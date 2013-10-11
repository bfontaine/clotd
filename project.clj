(defproject clotd "0.1.0"
  :description "A QOTD server"
  :url "https://github.com/bfontaine/clotd"
  :main clotd.core
  :aot [clotd.core]
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure       "1.5.1"]
                 [log4j/log4j               "1.2.16" :exclusions
                                                     [javax.mail/mail
                                                      javax.jms/jms
                                                      com.sun.jdmk/jmxtools
                                                      com.sun.jmx/jmxri]]
                 [org.clojure/tools.logging "0.2.6"]
                 [tcp-server                "0.1.0"]])
