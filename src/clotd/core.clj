(ns clotd.core
  (:require [net.tcp.server        :as ts]
            [clojure.tools.logging :as lg]
            [clotd.fortune         :as ft]))

;; We're using 1717 for tests, since it doesn't require to be root
;; TODO put it in a config file or as a command-line argument
(def port 1717)

(defn- mk-handler
  [quotes]
  (fn [_ writer]
    (let [q (rand-nth quotes)]
      (.append writer q)
      (if (not= (last q) \newline)
        (.append writer "\n")))))

(defn- mk-server
  [port quotes]
  (ts/tcp-server
    :port port
    :handler (ts/wrap-io (mk-handler quotes))))

(defn -main
  [& args]
  (let [filename (first args)]
    (if (nil? filename)
      (do
        (lg/error "A fortune file is needed!")
        (System/exit -1))
      (let [quotes (ft/read-quotes filename)
            server (mk-server port quotes)]
        (lg/info "Got" (count quotes) "quotes from" filename)
        (lg/info (str "Starting server on port " port "..."))
        (lg/info "Press ^C to stop.")
        (ts/start server)))))
