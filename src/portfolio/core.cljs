(ns portfolio.core
    (:require
      [reagent.core :as r]
      [stylefy.core :as stylefy]))

;; -------------------------
;; SiteMap

(def projects
  [{:title "Me" :section "#" :deploy "#" :github "#"}
  {:title "Recipe Share" :section "#" :deploy "#" :github "#"}
  {:title "MUD" :section "#" :deploy "#" :github "#"}
  {:title "Ingspel" :section "#" :deploy "#" :github "#"}])

;; -------------------------
;; Styles

; (stylefy/font-face
;   {:font-family "IBM Plex Mono Text"
;    :src "url('./fonts/IBMPlexMono-Text.otf') format('opentype')"
;    :font-weight "normal"
;    :font-style "normal"})
; (stylefy/font-face
;   {:font-family "IBM Plex Sans Bold"
;    :src "url('./fonts/IBMPlexSans-Bold.otf') format('opentype')"
;    :font-weight "bold"
;    :font-style "normal"})
; (stylefy/font-face
;   {:font-family "IBM Plex Sans Bold Italic"
;    :src "url('./fonts/IBMPlexSans-Bold-Italic.otf') format('opentype')"
;    :font-weight "bold"
;    :font-style "italic"})
; (stylefy/font-face
;   {:font-family "IBM Plex Sans"
;    :src "url('./fonts/IBMPlexSans-Text.otf') format('opentype')"
;    :font-weight "normal"
;    :font-style "normal"})
; (stylefy/font-face
;   {:font-family "IBM Plex Sans Italic"
;    :src "url('./fonts/IBMPlexSans-TextItalic.otf') format('opentype')"
;    :font-weight "normal"
;    :font-style "italic"})

(def palette
  {:off-black "#0C0816"
   :off-white "#F4EFFC"
   :lavender "#D1BEF4"
   :blue "#3B77CB"
   :purple "#362560"})

(def blue-test
  {:background-color "lavender"
   :color "grey"})

(def hud-right
  {:position :fixed
   :right 0
   :display :flex
   :flex-direction :column})

(def nav-link
  {:font-size 20
   :color (:blue palette)
   :padding "3px 20px"})
;; -------------------------
;; Components

(defn heading []
  [:h2 {:style {:color (:blue palette)}} "HEADER"])

(defn navbar []
  [:nav (stylefy/use-style hud-right)
   (for [{text :title destination :page} projects]
     [:a (stylefy/use-style nav-link {:href destination}) text])
   ])


(defn content []
  [:<>
   [:h2 "About Me"]
   [:p "Nullam eu augue augue. Interdum et malesuada fames ac ante ipsum primis in faucibus. Fusce luctus massa nisi, et rhoncus augue bibendum vel. Vestibulum iaculis mollis ultrices. Integer fringilla sollicitudin nunc eu efficitur. Phasellus lacinia bibendum lorem, at volutpat elit dictum id. Donec convallis lacus venenatis tincidunt tincidunt. Vestibulum quis urna eu tellus mollis ornare. Nulla iaculis diam hendrerit molestie mollis. Nunc id justo sit amet arcu vestibulum pulvinar. Cras consectetur, sapien a iaculis dapibus, nibh velit tincidunt turpis, eu mollis velit dui sed arcu. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Phasellus egestas, erat ut vulputate feugiat, nunc enim tristique quam, sed vehicula neque tortor sed purus."]
   [:h2 "Skills"]
   [:ul
    [:li "JavaScript React"]
    [:li "Python"]
    [:li "CSS LESS Sass"]
    [:li "SQLite Knex.js"]]
   [:h2 "Projects"]
   [:h3 "Recipe Share"]
   [:p "This React Native app is a platform for organizing and sharing recipe innovations."]
   [:h3 "Treasure Hunt"]
   [:p "An ASCII grid displays an automated blockchain-themed fantasy game."]
   [:h3 "MUD"]
   [:p "Walk around a randomly generated maze."]
   [:h3 "Ingspel"]
   [:p "English spellings with as obvious a pronunciation as possible are generated from phonetic transcription with this TypeScript utility."]
   [:h3 "Esperanto Uninflect"]
   [:p "This Clojure library converts Esperanto vocabulary words in the wild to dictionary form for easy translation into English."]
   [:h3 "Maui"]
   [:p "Inspired by an old legend, I generated procedural world maps via a (highly simplified) climate simulation to explore what a flat Earth might look like."]])

(defn footer []
  [:h2 "(built with ClojureScript and Reagent)"])

(defn scaffolding []
  [:<>
   [heading]
   [navbar]
   [content]
   [footer]])

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [scaffolding] (.getElementById js/document "app")))

(defn init! []
  (stylefy/init)
  (mount-root))
