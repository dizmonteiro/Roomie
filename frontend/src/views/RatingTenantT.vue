<template>
  <div>
    <TenantNavbar />
    <div class="columns is-centered is-vcentered is-mobile is-tablet is-desktop is-multiline">
        <div class="column is-11-mobile is-11-tablet is-11-desktop">
            <div id="ratetenantt-card">

                <div class="block">
                  <div class="columns is-centered is-mobile is-tablet is-desktop">
                  
                    <div class="column is-one-fourth-mobile is-one-fourth-tablet is-one-fourth-desktop">
                      <div class="box custom-height">
                          <div class="columns is-centered is-vcentered is-mobile is-tablet is-desktop">
                          
                            <div class="column is-three-quarters-mobile is-three-quarters-tablet is-three-quarters-desktop">

                                <div class="block">
                                    <figure class="image avatar">
                                        <img
                                            class="is-rounded"
                                            src="https://thisrentaldoesnotexist.com/img-new/face.jpg"
                                        />
                                    </figure>
                                </div>
                                
                                <div class="box">
                                </div>

                            </div>

                          </div>
                      </div>
                    </div>

                    <div class="column is-two-thirds-mobile is-two-thirds-tablet is-two-thirds-desktop">
                        <div class="box custom-height">
                          <check-rates/>
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

export default {
  data(){
    return {
    
    }
  },

  name: 'Tenant Rate Tenant',

  components: {
    TenantNavbar
  }
}
</script>

<style scoped>

  #content {
    margin: 3% auto 2% auto;
    width: 100%;
  } 
  
  #ratetenantt-card {
      min-height: 80vh;
      margin-top: 5%;
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

  img {
    object-fit: contain;
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