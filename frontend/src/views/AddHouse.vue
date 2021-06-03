<template>
  <div>
    <LandlordNavbar />
    <div class="columns is-centered is-vcentered is-mobile is-tablet is-desktop is-multiline">
        <div class="column is-four-fifths-mobile is-four-fifths-tablet is-three-quarters-desktop">
            <div class="card" id="form-card">
                <div class="card-content">
                    <p class="title has-text-centered">Add New House</p>
                    <FormulateForm v-model="formData" class="columns is-centered" @submit="submitHouse">
                        <div class="column is-full-mobile is-full-tablet is-one-third-desktop">
                            <FormulateInput
                                name="title"
                                label="House Title"
                                type="text"
                                validation="required|max:250,length|min:5,length"
                            />
                            <FormulateInput
                                name="address"
                                label="Address"
                                type="text"
                                validation="required|max:100,length|min:5,length"
                            />
                            <FormulateInput
                                name="bedrooms"
                                label="Number of Bedrooms"
                                type="number"
                                validation="required|number"
                                min="0"
                                max="10"
                            />
                            <FormulateInput
                                name="available"
                                label="Available Bedrooms"
                                type="number"
                                validation="required|number"
                                min="0"
                                max="10"
                            />
                            <FormulateInput
                                name="bathrooms"
                                label="Number of Bathrooms"
                                type="number"
                                validation="required|number"
                                min="0"
                                max="10"
                            />
                            <div class="price-range">
                                <FormulateInput
                                    name="minprice"
                                    label="Min. Price p/ Bedroom"
                                    type="number"
                                    validation="required|number"
                                    min="0"
                                />
                                <div class="spacer"></div>
                                <FormulateInput
                                    name="maxprice"
                                    label="Max. Price p/ Bedroom"
                                    type="number"
                                    validation="required|number"
                                    min="0"
                                />
                            </div>
                        </div>
                        <div class="column is-full-mobile is-full-tablet is-one-third-desktop">
                            <FormulateInput
                                type="textarea"
                                name="description"
                                label="Description"
                                validation="required"
                                rows="10"
                            />
                            <div id="scroll-area-1">
                                <smooth-scrollbar>
                                    <FormulateInput
                                        type="group"
                                        name="features"
                                        :repeatable="true"
                                        label="Features"
                                        add-label="Add Feature"
                                        validation="required"
                                    >
                                        <FormulateInput
                                            name="feature"
                                            type="text"
                                            validation="required"
                                        />
                                    </FormulateInput>
                                </smooth-scrollbar>
                            </div>
                        </div>
                        <div class="column is-full-mobile is-full-tablet is-one-third-desktop">
                            <div id="scroll-area-2">
                                <smooth-scrollbar>
                                    <FormulateInput
                                        type="image"
                                        name="photos"
                                        label="Photos"
                                        help="Select a png, jpg or gif to upload."
                                        validation="required|mime:image/jpeg,image/png,image/gif"
                                        multiple
                                        upload-behavior="delayed"
                                        :uploader="uploadFile"
                                    />
                                </smooth-scrollbar>
                            </div>
                            <FormulateInput
                                type="submit"
                                label="Add House"
                            />
                        </div>
                    </FormulateForm>
                </div>
            </div>
        </div>
    </div>
    <div class="modal" id="modal">
        <div class="modal-background"></div>
          <div class="modal-content">
            <div class="card">
              <div class="card-content is-vcentered">
                <div class="content has-text-centered">
                  <br>
                  <h1>House added!</h1>  
                  <br>
                  <br>
                  <button type="submit" class="button is-green" v-on:click="goToProfile()">Return to Home</button>
                </div>
              </div>
            </div>
        </div>
        <button class="modal-close is-large" aria-label="close" v-on:click="closeModal()"></button>
    </div>
  </div>
</template>

<script>
import LandlordNavbar from '@/components/LandlordNavbar'
import axios from 'axios';
import { url as api_url } from "@/assets/scripts/api";

function goToProfile() {
    window.location.replace("/landlord");
}

function closeModal() {
    document.getElementById("modal").classList.remove("is-active");
}



export default {
  name: 'Login',
  components: {
    LandlordNavbar
  },
  data() {
    return {
        formData: {
            file: [],
        }
    };
  },
  computed: {
    
  },
  methods: {
    /* eslint-disable-next-line */
    async uploadFile (file, progress, error, option) {
      this.formData.file.push(file);
    },
    closeModal,
    goToProfile,
    async submitHouse (data) {

        let features = []
        for(var f = 0; f < data.features.length; f++)
            features.push(data.features[f].feature)

        var bodyFormData = new FormData();
        bodyFormData.append('address', data.address);
        bodyFormData.append('features', features);
        bodyFormData.append('description', data.description);
        bodyFormData.append('minPrice', data.minprice);
        bodyFormData.append('maxPrice', data.maxprice);
        bodyFormData.append('bathRooms', data.bathrooms);
        bodyFormData.append('availableRooms', data.available);
        bodyFormData.append('rooms', data.bedrooms);
        bodyFormData.append('title', data.title);

        for(var i = 0; i < this.formData.file.length; i++){
            bodyFormData.append('files', this.formData.file[i]);
        }        

        let options = {
            headers: { 
            "Content-Type": "multipart/form-data" 
            }
        }
        
        await axios.post(api_url + '/api/houses', bodyFormData, options).then(() => {
            document.getElementById("modal").classList.add("is-active");
        }).catch(e => {
            alert(e)
        })
    }
  }
}
</script>


<style scoped>
    #form-card {
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
</style>