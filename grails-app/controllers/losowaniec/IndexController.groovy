package losowaniec

class IndexController {

    def combinatoricsService

    def index() {
        List liczby = 1..80
        [numbers: liczby]
    }

    def generate() {
        def n_system, n_all = Integer.valueOf(params.n_all==""? "0": params.n_all), n_sets=Integer.valueOf(params.n_sets==""? "0": params.n_sets), ilosc_zbiorow, sn
        def picked_numbers =[]
        def n_los=Integer.valueOf(params.n_los==""? "0" : params.n_los)
        def zbiory = []

        if(params.automatic=="y"){
            n_system=Integer.valueOf(params.n_system)
            zbiory = combinatoricsService.zbiory(n_all, n_system, n_los, n_sets)
        } else {
            println("A")
            picked_numbers=generatePickedNumbers(params.picked_numbers)
            n_system=picked_numbers.size()
            zbiory = combinatoricsService.zbiory(picked_numbers, n_system, n_los, n_sets)
        }

        if(n_los>n_system || n_system==0){
            render("view": "/index/error")
        } else {
            sn = combinatoricsService.ileZbiorow(n_los,n_system)
            ilosc_zbiorow = zbiory.size()
            [setsnumber: sn,
             pickedSetsnumber: ilosc_zbiorow,
             sets: zbiory]
        }
    }

    def numberspicker(){
        def numbers = 1..Integer.valueOf(params.howmany)
        [numbers:numbers]
    }

    def generatePickedNumbers(String ns){
        Set retArray = new TreeSet<Integer>()
        if(ns.trim().length()>0){
            def nsArray = ns.trim().split("  ")
            nsArray.each {it -> retArray.add(Integer.valueOf(it))}
        }
        return retArray
    }
}
