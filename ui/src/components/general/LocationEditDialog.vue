<template>
  <v-dialog v-model="show" max-width="500" persistent>
    <template #default>
      <v-card>
        <v-card-title>Add new location</v-card-title>
        <v-card-item>
          <v-text-field v-model="form.name" label="Name" />
          <v-textarea v-model="form.description" auto-grow label="Description" rows="1" />
        </v-card-item>
        <v-card-actions>
          <v-btn class="text-none" @click="save">Save</v-btn>
          <v-btn class="text-none" @click="close">Cancel</v-btn>
        </v-card-actions>
      </v-card>
    </template>
  </v-dialog>

  <v-snackbar v-model="showNotification" color="success" :timeout="1500">
    Successfully saved new location.
  </v-snackbar>
</template>

<script setup lang="ts">
import { UnwrapNestedRefs } from 'vue';
import { createLocation } from '@/utils/api/LocationApiUtils';

const show = defineModel<boolean>('show');

class Form {
  name: string = '';
  description: string = '';
}

const form: UnwrapNestedRefs<Form> = reactive(new Form());

const showNotification = ref<boolean>(false);

function reset () {
  Object.assign(form, new Form());
}

function save () {
  createLocation(form.name, form.description);
  showNotification.value = true;
  close();
}

function close () {
  show.value = false;
  reset();
}
</script>
