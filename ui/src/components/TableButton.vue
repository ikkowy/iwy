<template>
  <v-btn
    class="text-none"
    :disabled="props.disabled"
    :prepend-icon="props.icon"
    variant="text"
    @click="emit('click')"
  >
    {{ props.label }}
    <v-tooltip activator="parent" location="bottom">
      {{ props.tooltip }}
    </v-tooltip>
  </v-btn>
</template>

<script setup lang="ts">
interface Props {
  icon: string;
  label: string;
  tooltip?: string;
  disabled?: boolean;
}

const props = withDefaults(defineProps<Props>(), {
  icon: '',
  label: '',
  tooltip: '',
  disabled: false
});

const emit = defineEmits<{
  click: []
}>();
</script>
