<template>
  <div>
    <TenantNavbar />
    <div class="columns is-centered is-vcentered is-mobile is-tablet is-desktop is-multiline">
      <div class="column is-11-mobile is-11-tablet is-11-desktop">
        <div id="checkhouse-card">

          <div class="block">
            <div class="columns is-centered is-mobile is-tablet is-desktop">
              
              <div class="column is-one-fourth-mobile is-one-fourth-tablet is-one-fourth-desktop">
                <div class="box custom-height">
                    <ZDMCarousel :cards="cards" />
                </div>
              </div>

            </div>
          </div>
          
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TenantNavbar from '@/components/TenantNavbar.vue';
import ZDMCarousel from "@/components/ZDMCarousel.vue";

export default {
  data(){
    return {

      cards: [
        {
          headline: "António Ourives",
          text: "962956721",
          imgName1: "face1.svg",
          imgName2: "landlord.svg"
        },
        {
          headline: "Maria Madalena",
          text: "Average Rating 1",
          imgName1: "face2.svg",
          imgName2: "roommate.svg"
        },
        {
          headline: "Mafalda Costa",
          text: "Average Rating 2",
          imgName1: "face3.svg",
          imgName2: "roommate.svg"
        }
      ]
    }
  },

  name: 'Tenant Check House',

  components: {
    TenantNavbar,
    ZDMCarousel
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