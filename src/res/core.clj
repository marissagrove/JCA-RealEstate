(ns res.core
  (:require [compojure.core :refer [defroutes routes]]
            [ring.middleware.defaults :refer :all]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.file-info :refer [wrap-file-info]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [hiccup.middleware :refer [wrap-base-url]]
            [ring.adapter.jetty :as jetty]
            [res.routes.home :refer [home-routes]]
            [environ.core :refer [env]]))

(defn init []
  (println "site is starting"))

(defn destroy []
  (println "site is shutting down"))

(defroutes app-routes
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (routes home-routes app-routes)
      (handler/site)
      (wrap-base-url)))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 5000))]
        (jetty/run-jetty #'app {:port port :join? false})))
