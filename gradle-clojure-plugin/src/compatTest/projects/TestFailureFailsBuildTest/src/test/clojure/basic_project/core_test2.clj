(ns basic-project.core-test2
  (:require [basic-project.core :refer [hello]]
            [clojure.test :refer :all]))

(deftest test-hello
  (is (= "Hello World!" (hello "World!"))))

(deftest test-hello2
  (is (= "Hello World" (hello "Globe"))))
