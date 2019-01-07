package losowaniec

import grails.gorm.transactions.Transactional
import org.apache.commons.math3.util.CombinatoricsUtils

@Transactional
class CombinatoricsService {
    Random r = new Random()

    def zbiory(int zIluLiczb, int n, int ileLosowanych,int prawdopodobienstwo) {
        def intSet = generujLosowyZbior(zIluLiczb, n)
        return zbiory(intSet, n, ileLosowanych, prawdopodobienstwo)
    }

    def zbiory(Set intSet, int n, int ileLosowanych,int prawdopodobienstwo){
        def ret = [][]
        if(n> intSet.size() || intSet.size()<ileLosowanych){
            System.out.println("Wrong number given. Cannot create subsets of the given number from the set provided.");
            return new int[0][0];
        } else if(ileLosowanych==intSet.size()){
            return intSet
        } else {
            def vars = []
            int i=0;
            Iterator<int[]> cit = CombinatoricsUtils.combinationsIterator(intSet.size(), ileLosowanych);
            while(cit.hasNext()){
                int[] pit = cit.next();
                if(r.nextDouble()<prawdopodobienstwo/100.0){
                    def vrow = []
                    for(int j=0; j<pit.length; j++){
                        vrow.add(intSet[pit[j]])
                    }
                    vars.add(vrow)
                }
            }
            return vars;
        }
        return ret
    }

    def generujLosowyZbior(int zIluLiczb, int ileLiczb) {
            Set retSet = new TreeSet<Integer>()
            int ix=0;
            for(ix=0; ix<ileLiczb; ix++){
                while(!retSet.add(r.nextInt(zIluLiczb)+1)){}
            }
            return retSet
    }

    def ileZbiorow(int ileLiczb, int ileSystem){
        return CombinatoricsUtils.binomialCoefficient(ileSystem, ileLiczb)
    }

    def uzytoZniorow(int percent, int available){
        return available * percent/100
    }
}
