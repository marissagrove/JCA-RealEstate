(ns res.views.layout
  (:require [hiccup.page :refer [html5 include-css]]
            [res.models.common :as common]))

(defn common [& body]
  (html5
   [:head
    [:title "JCA Real Estate"]
    [:link {:href "/css/screen.css", :rel "stylesheet", :type "text/css"}]]
   [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
   [:body common/navbar]))
