(ns portfolio.core
    (:require
      [reagent.core :as r]
      [stylefy.core :as stylefy]))

;; -------------------------
;; SiteMap

(def projects
  [{:title "Me" :page "#" :deploy "#" :github "#"}
  {:title "Recipe Share" :page "#" :deploy "#" :github "#"}
  {:title "MUD" :page "#" :deploy "#" :github "#"}
  {:title "Ingspel" :page "#" :deploy "#" :github "#"}])

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
  [:h2 {:style {:color (:blue palette)}} "Salutations, external reality."])

(defn navbar []
  [:nav (stylefy/use-style hud-right)
   (for [{text :title destination :page} projects]
     [:a (stylefy/use-style nav-link {:href destination}) text])
   ])

(defn content []
  [:<>
   [:h2 "About Me"]
   [:p "In the future, will you be able to ethically transform standpoints in your business? Change the way you do business - adopt seamless architectures. Going forward, our long-term capability will deliver value to dot-bombs. We thrive because of our competitive deliverable and mission critical driver culture."]
   [:h2 "Skills"]
   [:p "Reliably touching base about synergising clouds will make us leaders in the unparalleled milestone industry. So we can hit the ground running, we will be virtually offshoring every low hanging fruit in our space. Our executive search development lifecycle enables holistic, innovative verticals. You need to strategically invest your game changers to increase your innovation velocity."]]
  )

(defn footer []
  [:h2 {:style {:color (:lavender palette)}} "Valedictions, cruel universe."])

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
