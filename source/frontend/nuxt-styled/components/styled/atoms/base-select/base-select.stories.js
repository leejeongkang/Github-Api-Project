import BaseSelect from "./base-select.vue";

export default {
  title: 'Styled/Atoms/[PCFI] 셀렉트 박스',
  components: BaseSelect,
  decorators: [
    () => ({
      template:
        '<div style="margin: 1em;"><h2 style="margin-bottom: 20px; font-size: 20px; color: #212121;">(예시) Select Element </h2><div style="display: flex; flex-direction: row; "><story /></div></div>',
    }),
  ],
};

export const Default = () => ({
  components: {BaseSelect},
  template:
    `
      <div class="v-group v-group--gap-12">
      <BaseSelect class='select--lg'></BaseSelect>
      <BaseSelect></BaseSelect>
      <BaseSelect class='select--sm'></BaseSelect>
      </div>
    `
});

export const SelectBorderless = () => ({
  components: {BaseSelect},
  template:
    `
      <div class="v-group v-group--gap-12">
      <BaseSelect class='select--borderless select--lg'></BaseSelect>
      <BaseSelect class='select--borderless'></BaseSelect>
      <BaseSelect class='select--borderless select--sm'></BaseSelect>
      </div>
    `
});

