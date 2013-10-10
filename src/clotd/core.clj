(ns clotd.core
  (:require [net.tcp.server        :as ts]
            [clojure.tools.logging :as lg]))

(def port 17)

(defn- handler [_ writer]
  (.append writer "Hello World\n"))

(def server
  (ts/tcp-server
    :port port
    :handler (ts/wrap-io handler)))

(defn -main []
  (lg/info (str "Starting server on port " port "..."))
  (lg/info "Press ^C to stop.")
  (ts/start server))
