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
          headline1: "Name Template 1",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1:"/",
          headline2: "Name Template 2",
          text2: "Template 2",
          imgName2: "house2.jpg",
          link2:"/",
          headline3: "Name Template 3",
          text3: "Template 3",
          imgName3: "house3.jpg",
          link3:"/",
          headline4: "Name Template 4",
          text4: "Template 4",
          imgName4: "house4.jpg",
          link4:"/",
          headline5: "Name Template 5",
          text5: "Template 5",
          imgName5: "house5.jpg",
          link5:"/",
          headline6: "Name Template 6",
          text6: "Template 6",
          imgName6: "house6.jpg",
          link6:"/"
        },
        {
          headline1: "Name Template 7",
          text1: "Template 7",
          imgName1: "house7.jpg",
          link1:"/",
          headline2: "Name Template 8",
          text2: "Template 8",
          imgName2: "house8.jpg",
          link2:"/",
          headline3: "Name Template 9",
          text3: "Template 9",
          imgName3: "house9.jpg",
          link3:"/",
          headline4: "Name Template 10",
          text4: "Template 10",
          imgName4: "house10.jpg",
          link4:"/",
          headline5: "Name Template 11",
          text5: "Template 11",
          imgName5: "house11.jpg",
          link5:"/",
          headline6: "Name Template 12",
          text6: "Template 12",
          imgName6: "house12.jpg",
          link6:"/"
        },
        {
          headline1: "Name Template 13",
          text1: "Template 13",
          imgName1: "house13.jpg",
          link1:"/",
          headline2: "Name Template 14",
          text2: "Template 14",
          imgName2: "house14.jpg",
          link2:"/",
          headline3: "Name Template 15",
          text3: "Template 15",
          imgName3: "house15.jpg",
          link3:"/",
          headline4: "Name Template 16",
          text4: "Template 16",
          imgName4: "house16.jpg",
          link4:"/",
          headline5: "Name Template 17",
          text5: "Template 17",
          imgName5: "house17.jpg",
          link5:"/",
          headline6: "Name Template 18",
          text6: "Template 18",
          imgName6: "house18.jpg",
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