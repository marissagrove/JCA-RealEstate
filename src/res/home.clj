(ns res.routes.home
  (:require [compojure.core :refer :all]
            [res.views.layout :as layout]
            [res.models.blog  :as blog]))

(defn home []
  (layout/common))

(defroutes home-routes
  (GET "/" [] (home)))
