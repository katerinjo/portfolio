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
    [:li "Praesent sed diam at sapien elementum scelerisque"]
    [:li "Integer at purus in eros mattis venenatis sed pellentesque nulla"]
    [:li "Suspendisse at arcu vel tellus posuere fermentum"]
    [:li "Nulla tempor urna id imperdiet luctus."]]
   [:h2 "Projects"]
   [:h3 "Recipe Share"]
   [:p "This React Native app is a platform for sharing recipes and tracking innovations made to them."]
   [:h3 "Treasure Hunt"]
   [:p "An ASCII grid display watches an automated blockchain-themed fantasy game."]
   [:h3 "MUD"]
   [:p "Walk around a randomly generated maze."]
   [:h3 "Ingspel"]
   [:p "English orthography with as clear a pronunciation as possible is generated from phonetic transrciption with this JavaScript utility."]
   [:h3 "Esperanto Uninflect"]
   [:p "This Clojure library converts Esperanto vocabulary words in the wild to dictionary form for easy translation into English."]
   [:h3 "Maui"]
   [:p "Inspired by an old legend, I made a (highly simplified) climate simulation to explore what a flat world might look like."]])

(defn footer []
  [:h2 "FOOTER"])

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
