import { model, Schema } from 'mongoose';

const Account = new Schema(
  {
    id: { type: String, required: true },
    accountName: { type: String, required: true },
    address: { type: String, default: '' },
    country: { type: String, default: '' },
    legalEntity: { type: String, default: '' },
    users: {
      type: [
        {
          accountId: String,
          uuid: String,
          userId: String,
          title: String,
          firstName: String,
          lastName: String,
          fullName: String,
          assigned: Boolean,
        },
      ],
      default: [],
    },
  },
  { _id: false },
);

const dateOptions = new Schema(
  {
    dateoptions: { type: String, required: true },
    daterangeend: { type: String, default: null },
    daterangestart: { type: String, default: null },
  },
  { _id: false },
);

const formData = new Schema(
  {
    account: { type: Account, required: true },
    daterange: { type: dateOptions, required: true },
    reportName: { type: String, required: true },
    service: { type: String, required: true },
  },
  { _id: false },
);

const payload = new Schema(
  {
    label: { type: String, required: true },
    parameters: {
      type: [
        {
          paramName: String,
          paramValue: String,
        },
      ],
      default: [],
    },
    reportType: {
      type: {
        reportCode: String,
        reportName: String,
      },
      required: true,
    },
  },
  { _id: false },
);

const templateSchema = new Schema({
  userId: { type: String, required: true, trim: true, index: true },
  filterName: { type: String, required: true, unique: true, trim: true },
  formData: { type: formData, required: true },
  payload: { type: payload, required: true },
  schemaType: { type: String, required: true },
  serviceParam: { type: String, required: true },
  savedAt: { type: Number, default: Date.now() },
});

templateSchema.set('toJSON', { virtuals: true });

export const templateModel = model('report-template', templateSchema);


// Properties: 
// required: true,
// 	lowercase: true,
//  trim: true,
// 	index: true,
// 	unique: true,
// { type: ObjectId , ref:'user' }
// enum: ['a','b']


// Virtuals:

// userSchema.virtual('name').get(function() { return `${this.first_name} ${this.last_name}`; });


// Middlewares:
// userSchema.post('init', function(doc) {
// 	console.log('%s has been initialized from the db', doc._id);
// });
// userSchema.post('validate', function(doc) {
// 	console.log('%s has been validated (but not saved yet)', doc._id);
// });
// userSchema.post('save', function(doc) {
// 	console.log('%s has been saved', doc._id);
// });
// userSchema.post('remove', function(doc) {
// 	console.log('%s has been removed', doc._id);
// });
// userSchema.post('updateOne', function(doc) {
// 	console.log('%s one has been updated', doc._id);
// });
// userSchema.post('deleteOne', function(doc) {
// 	console.log('%s one has been removed', doc._id);
// });


