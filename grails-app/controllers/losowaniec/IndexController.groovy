package losowaniec

import grails.web.servlet.mvc.GrailsParameterMap

class IndexController {

    def combinatoricsService

    def index() {
        List liczby = 1..80
        [numbers: liczby]
    }

    def generate() {

        InitialParams iparams = new InitialParams(params)

        if(isValid(iparams)){
            def ilosc_zbiorow, sn
            def zbiory = []

            if(iparams.automatic=="y"){
                zbiory = combinatoricsService.zbiory(iparams.n_all, iparams.n_system, iparams.n_los, iparams.n_sets)
            } else {
                n_system=picked_numbers.size()
                zbiory = combinatoricsService.zbiory(iparams.picked_numbers, iparams.n_system, iparams.n_los, iparams.n_sets)
            }
                sn = combinatoricsService.ileZbiorow(iparams.n_los,iparams.n_system)
                ilosc_zbiorow = zbiory.size()
                [setsnumber: sn,
                 pickedSetsnumber: ilosc_zbiorow,
                 sets: zbiory]
        } else {
            render("view": "/index/error")
        }

    }

    def numberspicker(){
        def numbers = 1..Integer.valueOf(params.howmany)
        [numbers:numbers]
    }


    private boolean isValid(InitialParams initialParams){
        return (initialParams.n_system>=initialParams.n_los && initialParams.n_all> initialParams.n_los && initialParams.n_all>initialParams.n_system)
    }
}
