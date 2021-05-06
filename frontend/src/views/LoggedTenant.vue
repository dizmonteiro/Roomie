<template>
  <div>
    <TenantNavbar />
    <div class="columns is-centered is-vcentered is-mobile is-tablet is-desktop is-multiline">
      <div class="column is-11-mobile is-11-tablet is-11-desktop">

        <div class="block">
              <ZDMHouseCarousel :panels="panels" />
        </div>
          
      </div>
    </div>
  </div>
</template>

<script>
import TenantNavbar from '@/components/TenantNavbar.vue';
import ZDMHouseCarousel from "@/components/ZDMHouseCarousel.vue";

export default {
  data(){
    return {

      panels: [
        {
          headline1: "Casa1",
          text1: "a casa 1 e cool e nice",
          imgName1: "img2.svg",
          link1:"/",
          headline2: "Casa2",
          text2: "a casa 1 e cool e nice",
          imgName2: "img2.svg",
          link2:"/",
          headline3: "Casa3",
          text3: "a casa 1 e cool e nice",
          imgName3: "img2.svg",
          link3:"/",
          headline4: "Casa4",
          text4: "a casa 1 e cool e nice",
          imgName4: "img2.svg",
          link4:"/",
          headline5: "Casa5",
          text5: "a casa 1 e cool e nice",
          imgName5: "img2.svg",
          link5:"/",
          headline6: "Casa6",
          text6: "a casa 1 e cool e nice",
          imgName6: "img2.svg",
          link6:"/"
        },
        {
          headline1: "Casa7",
          text1: "a casa 1 e cool e nice",
          imgName1: "img2.svg",
          link1:"/",
          headline2: "Casa8",
          text2: "a casa 1 e cool e nice",
          imgName2: "img2.svg",
          link2:"/",
          headline3: "Casa9",
          text3: "a casa 1 e cool e nice",
          imgName3: "img2.svg",
          link3:"/",
          headline4: "Casa10",
          text4: "a casa 1 e cool e nice",
          imgName4: "img2.svg",
          link4:"/",
          headline5: "Casa11",
          text5: "a casa 1 e cool e nice",
          imgName5: "img2.svg",
          link5:"/",
          headline6: "Casa12",
          text6: "a casa 1 e cool e nice",
          imgName6: "img2.svg",
          link6:"/"
        },
        {
          headline1: "Casa1",
          text1: "a casa 1 e cool e nice",
          imgName1: "img2.svg",
          link1:"/",
          headline2: "Casa2",
          text2: "a casa 1 e cool e nice",
          imgName2: "img2.svg",
          link2:"/",
          headline3: "Casa3",
          text3: "a casa 1 e cool e nice",
          imgName3: "img2.svg",
          link3:"/",
          headline4: "Casa4",
          text4: "a casa 1 e cool e nice",
          imgName4: "img2.svg",
          link4:"/",
          headline5: "Casa5",
          text5: "a casa 1 e cool e nice",
          imgName5: "img2.svg",
          link5:"/",
          headline6: "Casa6",
          text6: "a casa 1 e cool e nice",
          imgName6: "img2.svg",
          link6:"/"
        }
      ]
    }
  },

  name: 'Logged Tenant',

  components: {
    TenantNavbar,
    ZDMHouseCarousel
  },
    
}
</script>

<style scoped>

  #content {
    margin: 3% auto 2% auto;
    width: 100%;
  } 
  
  #checkhouse-card {
      min-height: 80vh;
      margin-top: 2%;
      margin-bottom: 5%;
  }

  #scroll-area-1 {
      height: 34vh;
  }

  #scroll-area-2 {
      height: 58vh;
      margin-bottom: 10px;
  }
  
  .price-range {
      display: flex;
      flex-direction: row;
      justify-content: space-between;
  }

  .spacer {
      width: 5px;
  }

  .vm {
    width: 25%;
    min-width: 70px;
  }

  .bordera {
  background-color: lightseagreen;
  }
  
  .borderb {
  background-color: pink;
  }

  .borderc {
  background-color: orange;
  }

  .custom-height {
    min-height: 80vh;
  }

</style>