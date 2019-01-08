package losowaniec

import grails.web.servlet.mvc.GrailsParameterMap

class InitialParams {

    def n_system, n_all, n_sets, n_los, automatic, picked_numbers = []
    InitialParams(GrailsParameterMap params){

        n_system = Integer.valueOf((params.n_system=="" || params.n_system==null)? "0": params.n_system)
        n_all = Integer.valueOf(params.n_all==""? "0": params.n_all)
        n_sets=Integer.valueOf(params.n_sets==""? "0": params.n_sets)
        n_los = Integer.valueOf(params.n_los==""? "0": params.n_los)
        automatic = params.automatic=="" ? "y" : params.automatic
        picked_numbers = generatePickedNumbers(params.picked_numbers)

    }

    def generatePickedNumbers(String ns){
        Set retArray = new TreeSet<Integer>()
        if(ns.trim().length()>0){
            def nsArray = ns.trim().split("  ")
            nsArray.each {it -> retArray.add(Integer.valueOf(it))}
            n_system=nsArray.length
        }
        return retArray
    }
}
