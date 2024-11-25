<template>
  <v-dialog v-model="showDialog" max-width="500" persistent>
    <template #default>
      <v-card>
        <v-card-title>{{ caption }}</v-card-title>
        <v-card-item>
          <v-text-field
            v-model="form.name"
            class="mt-2"
            density="comfortable"
            label="Name"
            variant="outlined"
          />
          <v-textarea
            v-model="form.description"
            auto-grow
            density="comfortable"
            label="Description"
            rows="1"
            variant="outlined"
          />
        </v-card-item>
        <v-card-actions>
          <v-btn class="text-none" @click="save">Save</v-btn>
          <v-btn class="text-none" @click="closeDialog">Cancel</v-btn>
        </v-card-actions>
      </v-card>
    </template>
  </v-dialog>

  <v-snackbar v-model="showNotification" color="success" :timeout="1500">
    Successfully saved new location.
  </v-snackbar>
</template>

<script setup lang="ts">
import { computed, reactive, ref } from 'vue';
import { createLocation, getLocationByUuid, updateLocation } from '@/utils/api/LocationApiUtils';

const emit = defineEmits<{
  success: []
}>();

defineExpose({ open });

class Form {
  name: string = '';
  description: string = '';
}

const form = reactive<Form>(new Form());

const showDialog = ref<boolean>(false);

const showNotification = ref<boolean>(false);

const locationUuid = ref<string | null>(null);

// TODO: Translate texts!
const caption = computed(() =>
  locationUuid.value === null ? 'Add new location' : 'Edit location');

async function open(uuid?: string) {
  if (uuid) {
    const locationDTO = await getLocationByUuid(uuid);
    form.name = locationDTO.name;
    form.description = locationDTO.description;
    locationUuid.value = uuid;
  }
  showDialog.value = true;
}

function reset() {
  Object.assign(form, new Form());
  locationUuid.value = null;
}

async function save() {
  if (locationUuid.value) {
    await updateLocation(locationUuid.value, form.name, form.description);
  } else {
    await createLocation(form.name, form.description);
  }
  emit('success');
  showNotification.value = true;
  closeDialog();
}

async function closeDialog() {
  showDialog.value = false;
  await new Promise(resolve => setTimeout(() => resolve, 500));
  reset();
}
</script>
