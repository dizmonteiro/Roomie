<template>
  <div>
    <TenantNavbar />
        <div id="content">
          <div class="columns is-centered is-vcentered">
            <div class="column is-three-fifths">
              <div class="card" id="loggedtenantcard">

                <div class="card-content">
                    <div class="column adjust-hero is-one-quarter-desktop is-full-mobile is-full-tablet has-text-centered">
                        <HouseList title="Houses" />
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
import HouseList from "@/components/HouseList.vue";

export default {

  name: 'LoggedTenant',

  components: {
    HouseList,
    TenantNavbar,
  }
}
</script>

<style scoped>

  #content {
    margin: 3% auto;
    width: 100%;
  }

  #preview {
    min-height: 200px;
    max-height: 200px;
  }

  #filler {
    min-height: 90vh;
  }

  @media (max-width: 770px) {
    #loggedtenantcard{
        margin: 3% auto;
        min-height: 80vh;
    }
  }

  label { display:block }

  .carousel {
    position:relative;
    overflow: hidden;
    max-width:100%;
    height:400px;
    z-index:10;
  }

  img {
    object-fit: contain;
  }
  
  .btn {
    padding:5px 10px;
    background-color:rgba(0,0,0,0);
    border:1px solid transparent;
    margin:5px 10px;
    color:#FFF;
    height:380px;
    width:100px;
    position:absolute;
    margin-top:-190px;
    z-index:2;
  }

  .btn:hover {
    cursor: pointer;
  }
    
  .btn:focus{
    outline:none;
  }
  
  .btn-next {
    top:50%;
    right:0;
  }
  
  .btn-prev {
    top:50%;
    left:0;
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
</style>