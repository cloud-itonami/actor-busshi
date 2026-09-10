(require '[busshi.methods.busshi-edn :as busshi-edn]
         '[busshi.methods.analyze :as analyze]
         '[busshi.methods.ie-flow :as ie-flow]
         '[clojure.pprint :as pprint]
         '[clojure.java.io :as io])

(let [commodities (busshi-edn/commodities "kotoba/seed.edn")
      outputs {"out/ie-flow-state.edn" (ie-flow/contract-state commodities)
               "out/analysis.edn" {:contract/id :busshi/commodity-analysis
                                   :contract/version 1
                                   :actor "busshi"
                                   :analysis (analyze/analyze commodities)}}]
  (doseq [[path value] outputs]
    (let [target (io/file path)]
      (.mkdirs (.getParentFile target))
      (spit target (with-out-str (pprint/pprint value)))
      (println "wrote" (.getPath target)))))
