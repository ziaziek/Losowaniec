package losowaniec

class IndexController {

    def combinatoricsService

    def index() { }

    def generate() {
        def sn = combinatoricsService.ileZbiorow(Integer.valueOf(params.n_los),Integer.valueOf(params.n_system))
        def zbiory = combinatoricsService.zbiory(Integer.valueOf(params.n_all), Integer.valueOf(params.n_system), Integer.valueOf(params.n_los), Integer.valueOf(params.n_sets))
        def ilosc_zbiorow = zbiory.size()
        [setsnumber: sn,
         pickedSetsnumber: ilosc_zbiorow,
        sets: zbiory]
    }
}
