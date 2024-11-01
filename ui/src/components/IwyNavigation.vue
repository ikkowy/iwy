<template>
  <v-card variant="text">
    <v-list>
      <v-list-item v-for="entry in props.entries" key="item.title" :href="entry.href" class="py-5" variant="text"
                   :disabled="entry.disabled">
        <template v-slot:prepend>
          <v-icon :icon="entry.icon" style="opacity: 1"></v-icon>
        </template>
        <v-list-item-title>{{ entry.title }}</v-list-item-title>
      </v-list-item>
    </v-list>
  </v-card>
</template>

<script setup lang="ts">
interface NavigationEntry {
  disabled?: boolean,
  href: string
  title: string,
  icon: string
}

interface Props {
  entries: NavigationEntry[];
}

const props = defineProps<Props>();
</script>
