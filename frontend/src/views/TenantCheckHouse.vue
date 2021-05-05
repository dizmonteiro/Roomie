<template>
  <div>
    <TenantNavbar />
    <div class="columns is-centered is-vcentered is-mobile is-tablet is-desktop is-multiline">
      <div class="column is-11-mobile is-11-tablet is-11-desktop">
        <div id="checkhouse-card">

          <div class="block">
            <div class="card-image">
              <carousel >
                <carousel-slide v-for="slide in slides" :key="slide" class="carousel-slider">
                  <img :src="slide" :alt="slide">
                </carousel-slide>
              </carousel>
            </div>
          </div>

          <div class="block">
            <div class="columns is-centered is-mobile is-tablet is-desktop">
              
              <div class="column is-one-fourth-mobile is-one-fourth-tablet is-one-fourth-desktop">
                <div class="box custom-height">
                  <p class="title has-text-centered is-one-third">Main Info</p>
                    <div class="columns is-centered is-vcentered is-mobile is-tablet is-desktop">

                      <div class="column is-half-mobile is-half-tablet is-half-desktop">
                        <div class="block">
                          <button class="button is-green is-static is-rounded">Template 1</button>
                        </div>
                        <div class="block">
                          <button class="button is-green is-static is-rounded">Template 2</button>
                        </div>
                        <div class="block">
                          <button class="button is-green is-static is-rounded">Template 3</button>
                        </div>
                      </div>

                      <div class="column is-half-mobile is-half-tablet is-half-desktop">
                        <div class="block">
                          <button class="button is-green is-static is-rounded">Template 4</button>
                        </div>
                        <div class="block">
                          <button class="button is-green is-static is-rounded">Template 5</button>
                        </div>
                        <div class="block">
                          <button class="button is-green is-static is-rounded">Template 6</button>
                        </div>
                      </div>

                    </div>
                </div>
              </div>
              
              <div class="column is-half-mobile is-half-tablet is-half-desktop">
                <div class="box custom-height">
                  <p class="title has-text-centered is-one-third">Description</p>
                  <div class="content has-text-justified">
                    <p>
                      A Roomie é uma Plataforma de Procura e Disponibilização de Imobiliário para Arrendamento que procura não só facilitar o processo de encontrar uma habitação como também o processo da escolha do ambiente em que se pretende viver.
                    </p>
                  </div>
                </div>
              </div>
              
              <div class="column is-one-fourth-mobile is-one-fourth-tablet is-one-fourth-desktop">
                <div class="box custom-height">
                    <ZDMCarousel :cards="cards" />
                </div>
              </div>

            </div>
          </div>

          <div class="block">
            <div class="buttons is-centered">
              <a class="button is-large is-green is-rounded vm">
                Apply For House
              </a>
            </div>
          </div>
          
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TenantNavbar from '@/components/TenantNavbar.vue';
import Carousel from '@/components/Carousel.vue';
import CarouselSlide from '@/components/CarouselSlide.vue';
import ZDMCarousel from "@/components/ZDMCarousel.vue";

export default {
  data(){
    return {
      slides: [
          'https://picsum.photos/id/164/1080/720',
          'https://picsum.photos/id/163/1080/720',
          'https://picsum.photos/id/308/1080/720',
          'https://picsum.photos/id/322/1080/720',
          'https://picsum.photos/id/351/1080/720',
          'https://picsum.photos/id/369/1080/720',
          'https://picsum.photos/id/398/1080/720'
      ],

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
    Carousel: Carousel,
    CarouselSlide: CarouselSlide,
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

  .carousel {
    position:relative;
    overflow: hidden;
    max-width:100%;
    height:46vh;
    z-index:10;
  }

  img {
    object-fit: contain;
  }

  .carousel-slider {
    position:absolute;
    top:10;
    left:0;
    bottom:0;
    right:0;
  }
  
  .carousel-slider img {
    width:100%;
    height:100%;
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
    min-height: 40vh;
  }

</style>